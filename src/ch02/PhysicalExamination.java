package ch02;

import java.util.Scanner;

public class PhysicalExamination {
    static final int VMAX = 21;

    static record PhyscData(
        String name,
        int height,
        double vision){}

    // 키의 평균값 구하기
    static double aveHeight(PhyscData[] dat){
        double sum = 0;
        for(PhyscData d : dat){
            sum += d.height;
        }
        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] dist){
        int i =0;
        dist[i] = 0;
        for(i = 0; i < dat.length; i++){
            if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX /10.0){
                dist[(int)(dat[i].vision * 10)]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("강민하",162,0.3),
                new PhyscData("김찬우",173,0.7),
                new PhyscData("박준서",175,2.0),
                new PhyscData("유서범",171,1.5),
                new PhyscData("이수연",168,0.4),
                new PhyscData("장경오",174,1.2),
                new PhyscData("황지안",169,0.8)
        };

        int[] vdist = new int[VMAX];

        System.out.println(" 신체 검사 리스트 ");
        System.out.println("이름      키     시력");
        System.out.println("-------------------");
        for(int i = 0;i < x.length;i++){
            System.out.printf("%-8s%3d%5.1f\n",x[i].name,x[i].height,x[i].vision);
        }

        System.out.printf("\n평균 키 : %5.1fcm\n",aveHeight(x));

        distVision(x,vdist); // 시력 분포 구하기

        System.out.println("\n시력 분포");
        for(int i = 0;i < VMAX;i++){
            System.out.printf("%3.1f~: %2d명\n", i / 10.0,vdist[i]);
        }
    }
}
