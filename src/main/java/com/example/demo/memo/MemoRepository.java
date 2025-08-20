package com.example.demo.memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository
{
    Memo save(Memo memo);
    List<Memo> findAll();
    Optional<Memo> findById(Long id);
    void delete(Long id);
}
