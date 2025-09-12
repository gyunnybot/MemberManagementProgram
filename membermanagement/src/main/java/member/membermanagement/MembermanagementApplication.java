package member.membermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MembermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembermanagementApplication.class, args);
	}

    /**
     * H2 database를 별도로 설치 후 실행해야 합니다!!
	 * 
	 * H2 다운로드 후, 저장 경로로 이동
	 * 
     * Windows : ~\H2\bin 폴더 경로 이동 -> h2.bat 실행
     * MacOS : ~/H2/bin 폴더 경로 이동 -> ./h2.sh 실행
     *
     * 처음 접속 시, 연결 후 전체 디렉토리에 test.mv.db 폴더가 생성되었는지 확인 + sql package 내 query 입력하여 테이블 생성
	 *
     * 이후 jdbc:h2:tcp://localhost/~/test 경로 확인 후 접속 가능
	 */
}
