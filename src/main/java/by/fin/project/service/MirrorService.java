package by.fin.project.service;

import by.fin.project.domain.Mirror;
import by.fin.project.exception.DAOException;
import by.fin.project.repository.MirrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MirrorService {

    @Autowired
    MirrorRepository mirrorRepository;

    public List<Mirror> getMirrors(){
        return mirrorRepository.findAll();
    }

    public Mirror saveMirror(Mirror mirror){
        if (Optional.ofNullable(mirrorRepository.findByUrl(mirror.getUrl())).isPresent()){
            throw new DAOException("Mirror exists");
        }
        mirror.setStatus(false);
        return mirrorRepository.save(mirror);
    }

    public Mirror updateMirror(Mirror mirror){
        if (!Optional.ofNullable(mirrorRepository.findByUrl(mirror.getUrl())).isPresent()){
            throw new DAOException("Mirror doesn't exists");
        }
        mirror.setStatus(false);
        return mirrorRepository.save(mirror);
    }

    public void deleteMirror(int id){
        if (!Optional.ofNullable(mirrorRepository.findById(id)).isPresent()){
            throw new DAOException("Mirror doesn't exists");
        }
        mirrorRepository.deleteById(id);
    }

}
