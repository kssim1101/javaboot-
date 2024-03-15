package sim.backend.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sim.backend.domain.Board;
import sim.backend.service.MybatisBoardService;

import java.util.List;

@RequestMapping("board")
@Controller
public class BoardController {
    @Autowired
    private MybatisBoardService service;
    @GetMapping("list.do")
    public String list(Model model) {
        List<Board> list = service.listS();
        model.addAttribute("list", list);
        //System.out.println("list"+list);
        return "/board/list"; // 해당 JSP 파일의 경로
    }
    @GetMapping("insert.do")
    public String insert(){
        return "/board/insert";
    }
    @PostMapping("insert.do")
    public String insert(Board board){
        service.insertS(board);
        return "redirect:list.do"; //작업수행 후 리스트로 이동 지시 전달
    }
    @GetMapping("content.do")
    public String content(@RequestParam("seq") int seq, Model model){
        Board board = service.contentS(seq);
        model.addAttribute("board", board);
        return "/board/content";
    }

    @GetMapping("del.do")
    public String delete(@RequestParam("seq") int seq){
        service.deleteS(seq);
        return "redirect:list.do";
    }
    @GetMapping("update.do")
    public String update(@RequestParam("seq") int seq,Model model){
        Board board = service.contentS(seq);
        model.addAttribute("board", board);
        return "/board/update";
    }
    @PostMapping("update.do")
    public String update(@ModelAttribute("board") Board board, RedirectAttributes redirectAttributes){
        service.updateSup(board);
        redirectAttributes.addAttribute("seq", board.getSeq()); // 수정된 항목의 seq를 쿼리 매개변수로 전달
        return "redirect:list.do"; // 리다이렉트 시에는 URL 경로를 완전한 경로로 지정해야 함
    }
}
