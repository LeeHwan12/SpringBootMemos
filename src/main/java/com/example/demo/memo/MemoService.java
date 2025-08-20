package com.example.demo.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public List<Memo> list(){return memoRepository.findAll();}
    public void add(String title) {
        memoRepository.save(Memo.builder().title(title).done(false).build());

    }

    public void toggle(Long id){
        memoRepository.findById(id).ifPresent(memo -> {
            memo.setDone(!memo.isDone());
            memoRepository.save(memo);
        });
    }

    public void delete(Long id) {
        memoRepository.delete(id);
    }
}
