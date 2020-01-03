import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.b1.member.MemberMapper;
import com.iu.b1.member.MemberVO;
@SpringBootTest
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void test() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("newni");
		memberVO.setPw("1234");
		memberVO.setEmail("newni123@email.com");
		memberVO.setName("newni");
	}

}
