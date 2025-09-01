# MemberManagementProgram(Spring Boot)
A simple Spring Boot + Thymeleaf project that demonstrates basic member registration and listing functionality.
Users can register by entering their name, and the application manages the member list in memory (or database if extended).

## 회원 등록, 관리 전체 프로세스
### 1. 홈 화면 진입

사용자가 웹 브라우저에서 localhost에 접속합니다.

홈 화면에는 보통 "회원 등록" 또는 "회원 목록" 으로 이동할 수 있는 메뉴가 있습니다.

### 2. 회원 등록 화면 이동

사용자가 "회원 등록" 메뉴를 클릭하면 GET /members/new 요청이 발생합니다.

컨트롤러(MemberController)의 createForm() 메서드가 실행되어 createMemberForm.html 템플릿을 반환합니다.

사용자에게 이름을 입력할 수 있는 폼 화면이 표시됩니다.

### 3. 회원 등록 데이터 입력

사용자가 입력창에 이름을 적고 "등록" 버튼을 누릅니다.

이때 브라우저는 POST /members/new 요청을 보냅니다.

### 4. 컨트롤러에서 데이터 받기

컨트롤러의 create(MemberForm form) 메서드가 호출됩니다.

HTML Form에서 입력받은 name="name"이 MemberForm 객체의 name 필드로 값이 자동 매핑됩니다.

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
    <form action="/members/new" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
        </div>
        <button type="submit">등록</button>
    </form>
</div> <!-- /container -->
</body>
</html>
```

새로운 Member 객체가 만들어지고, 그 안에 이름이 저장됩니다.

### 5. 서비스 계층에서 회원 저장

이후 컨트롤러는 memberService.join(member)를 호출합니다.

MemberService 는 비즈니스 로직(중복 회원 체크 등)을 처리한 뒤, MemberRepository 를 이용해 실제 저장소(메모리/DB)에 회원을 저장합니다.

```java
private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> { //결과가 어떤 값으로 존재한다면 예외 발생
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
```

### 6. 홈으로 리다이렉트

회원 가입이 끝나면 return "redirect:/";를 통해 홈 화면으로 돌아갑니다(Redirection).

사용자는 다시 홈 화면을 보게 됩니다.

```java
@PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // "/"로 리다이렉트
    }
```

### 7. 회원 목록 조회 (관리)

사용자가 "회원 목록" 메뉴를 클릭하면
GET /members 요청이 발생합니다.

컨트롤러의 List(Model model) 메서드가 실행되어, memberService.findMembers()로 전체 회원을 조회합니다.

조회한 회원 리스트를 model.addAttribute("members", members)로 뷰에 전달합니다.

memberList.html 템플릿에서 th:each 문법으로 회원들을 화면에 출력합니다.
