# Member Management Program(Spring Boot)

A simple Spring Boot + Thymeleaf project that demonstrates basic member registration and listing functionality.
Users can register by entering their name, and the application manages the member list in memory or database.

## 홈 화면 진입

사용자가 웹 브라우저에서 http://localhost:8080/ 에 접속합니다.

홈 화면에는 "회원 등록" 또는 "회원 목록" 으로 이동할 수 있는 메뉴가 있습니다.

## 회원 등록 (등록)

사용자가 "회원 등록" 메뉴를 클릭하면 GET /members/new 요청이 발생합니다.

컨트롤러(MemberController)의 createForm() 메서드가 실행되어 createMemberForm.html 템플릿을 반환합니다.

사용자에게 이름을 입력할 수 있는 폼 화면이 표시됩니다.

#### 1. 회원 등록 데이터 입력

사용자가 입력창에 이름을 적고 "등록" 버튼을 누릅니다.

브라우저는 POST /members/new 요청을 보냅니다.

#### 2. 컨트롤러에서 데이터 받기

컨트롤러의 create(MemberForm form) 메서드가 호출됩니다.

HTML name="name" → MemberForm 객체의 name 필드로 값이 자동 매핑됩니다.

새로운 Member 객체가 만들어지고, 그 안에 이름이 저장됩니다.

#### 3. 서비스 계층에서 회원 저장

컨트롤러는 memberService.join(member) 를 호출합니다.

MemberService 는 비즈니스 로직(중복 회원 체크 등)을 처리한 뒤, MemberRepository 를 이용해 실제 저장소(메모리 또는 DB)에 회원을 저장합니다.

#### 4. 홈으로 리다이렉트

회원 가입이 끝나면 return "redirect:/"; 로 홈 화면으로 돌아갑니다.

## 회원 목록 조회 (관리)

사용자가 "회원 목록" 메뉴를 클릭하면 GET /members 요청이 발생합니다.

컨트롤러의 List(Model model) 메서드가 실행되어, memberService.findMembers() 로 전체 회원을 조회합니다.

조회한 회원 리스트를 model.addAttribute("members", members) 로 뷰에 전달합니다.

memberList.html 템플릿에서 th:each 문법으로 회원들을 화면에 출력합니다.

## 데이터 저장 방식 변경

- Memory
- 순수 Jdbc
- Jdbc Template
- JPA
- 스프링 데이터 JPA (+AOP 추가)
