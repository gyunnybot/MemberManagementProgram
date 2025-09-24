package member.membermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MembermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembermanagementApplication.class, args);
	}

    /**
	 * 처음 연결 시 :
	 *
	 * H2 database 다운로드(https://www.h2database.com/html/main.html), 저장 경로로 이동
	 * 
     * Windows : 저장 경로\H2\bin -> h2.bat 실행
     * Mac : 저장 경로/H2/bin -> h2.sh 실행
     *
     * 사용자 폴더에 test.mv.db 폴더가 생성되었는지 확인
	 *
     * H2 콘솔 JDBC URL : jdbc:h2:tcp://localhost/~/test 로 변경
	 * application.properties : spring.datasource.url=jdbc:h2:tcp://localhost/~/test 로 변경
	 */
}
