package com.travel.proj.app.twit.service;

import com.travel.proj.app.twit.model.Reply;
import com.travel.proj.app.login.model.User;
import com.travel.proj.app.twit.repository.BoardRepository;
import com.travel.proj.app.twit.repository.ReplyRepository;
import com.travel.proj.app.twit.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public BoardService( BoardRepository boardRepository,ReplyRepository replyRepository){
        this.boardRepository = boardRepository;
        this.replyRepository = replyRepository;
    }

    @Transactional
    public void save(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional
    public void saveReply(int boardId, Reply reply, User user) {
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("해당 게시글이 없습니다.");
        });

        reply.setBoard(board);
        reply.setUser(user);

        replyRepository.save(reply);
    }
}
