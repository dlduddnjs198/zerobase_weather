package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest(){
        //given(어떤 데이터가 있을때)
        Memo newMemo = new Memo(10, "This is jps memo");
        //when(어떤 동작을 하게되면)
        jpaMemoRepository.save(newMemo);
        //then(어떤 결과가 나와야한다)
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size()> 0);
    }

    @Test
    void findByIdTest(){
        //given(어떤 데이터가 있을때)
        Memo newMemo = new Memo(10, "This is jps memo");
        //when(어떤 동작을 하게되면)
        Memo memo = jpaMemoRepository.save(newMemo);
        //then(어떤 결과가 나와야한다)
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "This is jps memo");
    }
}
