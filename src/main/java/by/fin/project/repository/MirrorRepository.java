package by.fin.project.repository;


import by.fin.project.domain.Mirror;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MirrorRepository extends JpaRepository<Mirror, Long> {

    Mirror save(Mirror mirror);
    void deleteById(int id);
    Mirror findByUrl(String url);
    Mirror findById(int url);

}

