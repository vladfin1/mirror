//package by.fin.project.thread;
//
//import by.fin.project.domain.Mirror;
//import by.fin.project.service.MirrorService;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Slf4j
//public class MirrorStatusThread extends Thread{
//
//    @Autowired
//    private MirrorService mirrorService;
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @SneakyThrows
//    public void run() {
//        List<Mirror> mirrors = mirrorService.getMirrors();
//        Thread.sleep(60000);
//        while (true){
//            mirrors.forEach((a)->{
//                try {
//                    restTemplate.exchange(a.getUrl() + "/api/area/ping", HttpMethod.GET, null, String.class);
//                    if(a.isStatus()==false){
//                        Mirror updated = a;
//                        updated.setStatus(true);
//                        mirrorService.updateMirror(updated);
//                    }
//                } catch (ResourceAccessException e){
//                    if(a.isStatus()==true){
//                        Mirror updated = a;
//                        updated.setStatus(false);
//                        mirrorService.updateMirror(updated);
//                    }
//                }
//            });
//            mirrors = mirrorService.getMirrors();
//        }
//
//    }
//
//}
