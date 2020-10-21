package modul3_4;

import java.util.ArrayList;

class pokemon{
    String nama,skill,region,trainer;
    String[] elemen = new String [4];
    boolean legend=false;
    ArrayList<String> owners = new ArrayList<String>();
}

class regular extends pokemon{
    regular(String nama,String skill, String region, String ele1){
        this.nama=nama;
        this.skill=skill;
        this.region=region;
        elemen[0]=ele1;
    }

}

class legendary extends pokemon{
    legendary(String nama, String skill, String region, String ele1, String ele2, String ele3, String ele4){
    	this.legend=true;
        this.nama=nama;
        this.skill=skill;
        this.region=region;
        elemen[0]=ele1;
        elemen[1]=ele2;
        elemen[2]=ele3;
        elemen[3]=ele4;
    }
}



class trainer{
    String nama,type;
    ArrayList<pokemon> mypet = new ArrayList<pokemon>();
    trainer(String nama, String type){
        this.nama=nama;
        this.type=type;
    }

    void infoTrainer(){
        System.out.println("\nNama : "+this.nama);
        System.out.println("Type : "+this.type);
    }

    void tambah(regular baru){
        baru.owners.add(nama);
        mypet.add(baru);
        System.out.println("\nPokemon berhasil ditambahkan");
    }
    void tambah(legendary baru) {
    	baru.trainer=nama;
        mypet.add(baru);
        System.out.println("\nPokemon berhasil ditambahkan");
    }
    
    
    void cari(String findNama){
        boolean ketemu=false;
        for (pokemon i : mypet) {
            if(i.nama.equalsIgnoreCase(findNama)){
                System.out.println("\nNama : "+i.nama);
                System.out.println("Skill : "+i.skill);
                System.out.print("Trainer : ");
                if(i.legend==true){
                	System.out.print(i.trainer);
                }
                else if(i.legend==false){
                    for(String z : i.owners) {
                    	System.out.print("["+z+"] ");
                    }
                }
                
                System.out.println("\nRegion : "+i.region);
                if(i.legend==true){
                    for(int z=0;z<4;z++){
                        System.out.println("Elemen "+(z+1)+" : "+i.elemen[z]);
                    }
                }
                else if(i.legend==false){
                    System.out.println("Elemen : "+i.elemen[0]);
                }
                ketemu=true;
                break;
            }
        }
        if(ketemu==false){
            System.out.println("\nPokemon Tidak Ditemukan");
        }

    }

    void hapus(String findNama){
        boolean gagal=true;
        for (pokemon i : mypet) {
            if(i.nama.equalsIgnoreCase(findNama)){
                if(i.legend==true){
                    break;
                }
                else if(i.legend==false){
                    mypet.remove(i);
                    for(int j=0;j<i.owners.size();j++){
                        String dare=i.owners.get(j);
                        if(dare.equalsIgnoreCase(this.nama)){
                            i.owners.remove(j);
                            break;
                        }
                    }
                    System.out.println("\nPokemon berhasil dilepas");
                    gagal=false;
                    break;
                }
            }
        }
        if(gagal==true){
            System.out.println("\nPokemon tidak ditemukan atau Pokemon bertipe Legendary");
        }

    }



}

public class Jurnal_modul34{
    public static void main(String[] args) {
    regular pikachu = new regular("Pikachu","Range","Middle East","Thunder");
    legendary giratina = new legendary("Giratina","Range","Other Dimension","Multiuniverse","Underworld","Fire","Pressure");
    trainer dary = new trainer("Dary","Melee");
    trainer zikry = new trainer("Zikry","Melee");
 
    dary.infoTrainer();
    zikry.infoTrainer();
    dary.tambah(pikachu);
    dary.tambah(giratina);
    zikry.tambah(pikachu);
    dary.cari("Pikachu");
    dary.cari("Giratina");
    dary.hapus("Pikachu");
    dary.cari("Pikachu");
    zikry.cari("Pikachu");
    }
}