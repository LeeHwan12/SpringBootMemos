package com.example.demo.memo;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMemoRepository implements MemoRepository {
    private final Map<Long, Memo> store = new ConcurrentHashMap<Long, Memo>();
    private final AtomicLong seq = new AtomicLong(0);

    @Override
    public Memo save(Memo memo) {
        if(memo.getId() == null)
            memo.setId(seq.incrementAndGet());
        if(memo.getCreatedAt() == null)
            memo.setCreatedAt(LocalDateTime.now());
        store.put(memo.getId(),memo);
        return memo;
    }

    @Override
    public List<Memo> findAll() {
        List<Memo> list = new ArrayList<>(store.values());
        list.sort(Comparator.comparing(Memo::getId));
        return list;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

}
