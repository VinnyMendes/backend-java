package Aula5.ex2.service.impl;


import Aula5.ex2.model.User;
import Aula5.ex2.service.IDownload;

public class DownloadProxy implements IDownload {
    private DownloadService downloadService;

    public DownloadProxy(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @Override
    public void fazerDownload(User user) {
        if(user.getPlano().equals("Premium")){
            downloadService.fazerDownload(user);
        }
        else{
            System.out.println("Por favor faça upgrade do seu plano para ter acesso a essa funcionalidade!");
        }
    }
}
