package sim.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor //모든필드 매개변수 받는 생성자
@NoArgsConstructor // 기본생성자
@Data // getter,setter 메소드 자동생성 + toString,equals,hasCode
public class Board {
    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
}
