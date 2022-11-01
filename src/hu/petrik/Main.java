package hu.petrik;

import java.awt.geom.QuadCurve2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Fuvar>fuvarok;
    public static void main(String[] args) {
        String fajlnev="fuvar.csv";
        try {
            beolvas(fajlnev);
            //fuvarok.forEach(System.out::println);
            System.out.printf("Az állományban %d fuvar került feljegyzésre\n",
                    fuvarok.stream().count());
            System.out.printf("A 6185-ös azonosítóju taxisnak %s bevétele volt %s fuvarból\n",
                    fuvarok.stream().filter(fuvar -> fuvar.getT_azosito()==6185).count(),
                    fuvarok.stream().filter(fuvar -> fuvar.getT_azosito()==6185).mapToDouble(Fuvar::getBevetel).sum());
            System.out.printf("%s m-t tettek meg a taxisok\n",
                    fuvarok.stream().mapToDouble(Fuvar::getTavolsag).sum());
            System.out.println("Leghosszabb fuvar: ");
                    fuvarok.stream()
                            .sorted((a,b)->b.getUtazas()-a.getUtazas())
                            .collect(Collectors.toList())
                            .stream().limit(1).forEach(System.out::println);
            System.out.printf("Legbőkezűbb: %s\n",
            fuvarok.stream().max(Comparator.comparingDouble(Fuvar::getArany_bokezo)));

            System.out.printf("A 4261 azonosítóju taxi %s km-t tett meg\n",
                    fuvarok.stream().filter(fuvar -> fuvar.getT_azosito()==4261)
                            .mapToDouble(Fuvar::getTavolsag).sum()*1.6);
            System.out.printf("Szerepel-e 1452-es fuvar: %s\n",
                    fuvarok.stream().anyMatch(fuvarok -> fuvarok.getT_azosito() == 1452));


            System.out.println("Legrövidebb fuvarok: ");
            fuvarok.stream()
                    .filter(fuvar -> fuvar.getUtazas()>0)
                    .sorted((a,b)->a.getUtazas()-b.getUtazas())
                    .collect(Collectors.toList())
                    .stream().limit(3).forEach(System.out::println);

            String datum="2016-12-24";
            System.out.printf("%s-én %d fuvar volt\n",datum,
                    fuvarok.stream().filter(fuvar -> fuvar.getIndulas().contains(datum)).count());

            System.out.println("December 31-én a borravalók aránya: ");
            List<Double> borravalok=fuvarok.stream()
                    .filter(fuvar -> fuvar.getIndulas().contains("2016-12-31"))
                    .map(Fuvar::getArany_bokezo)
                    .collect(Collectors.toList());
            borravalok.forEach(System.out::println);

        }catch (IOException e){
            System.out.printf("Hiba történt a fájl beolvasásakor", fajlnev);
        }
    }

    private static void beolvas(String fajlNev) throws IOException {
        fuvarok = new ArrayList<>();

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);

        String fejlec = br.readLine();

        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()){
            Fuvar i = new Fuvar(sor);
            fuvarok.add(i);
            sor = br.readLine();
        }

        br.close();
        fr.close();
    }
}
