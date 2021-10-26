package Aula5.ex2;


import Aula5.ex2.model.User;
import Aula5.ex2.service.IDownload;
import Aula5.ex2.service.impl.DownloadProxy;
import Aula5.ex2.service.impl.DownloadService;

public class Main {

    public static void main(String[] args) {

    User user = new User("Premium");

    IDownload proxy = new DownloadProxy(new DownloadService());

    proxy.fazerDownload(user);


    }
}
