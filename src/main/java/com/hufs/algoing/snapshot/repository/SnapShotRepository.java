package com.hufs.algoing.snapshot.repository;

import com.hufs.algoing.snapshot.entity.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnapShotRepository extends JpaRepository<Snapshot, Long>, SnapShotCustomRepository {
}
