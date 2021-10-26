package Aula5.ex2.service.impl;


import Aula5.ex2.model.User;
import Aula5.ex2.service.IDownload;

public class DownloadService implements IDownload {
    @Override
    public void fazerDownload(User user) {
        System.out.println("Download Feito com sucesso");
    }
}
