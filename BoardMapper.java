package sim.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sim.backend.domain.Board;

import java.util.List;
//DAO
@Mapper
@Repository
public interface BoardMapper {
    List<Board> list();
    void insertSelectKey(Board board);
    Board selectBySeq(int seq);

    void delete(int seq);
    void update(Board board);
}
