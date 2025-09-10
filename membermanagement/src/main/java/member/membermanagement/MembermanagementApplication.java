package member.membermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MembermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembermanagementApplication.class, args);
	}

    /**
     * h2 database 실행하기
     * Windows : ~\H2\bin 폴더 경로 이동 -> h2.bat 실행
     * MacOS : ~/H2/bin 폴더 경로 이동 -> ./h2.sh 실행
     *
     * 처음 접속 시, 연결 후 전체 디렉토리에 test.mv.db 폴더가 있는지 확인
     * 이후 jdbc:h2:tcp://localhost/~/test
     *
     * 처음 접속 시, sql package 내 query 입력 후 실행
     * */
}
