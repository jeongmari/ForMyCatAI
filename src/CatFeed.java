import java.util.Scanner;

public class CatFeed
{
   public static void main( String[] args )
   {
      Scanner sc = new Scanner( System.in );
      
    
      System.out.print( "ü��(����: kg): " ); // ü���� �Է¹���
      float weight = sc.nextFloat();
      
      float weight_discrimination[] = new float[ 3 ]; // ü�� �з� �迭 ����
      
      // ����
      if      ( weight >= 4 ) weight_discrimination[ 0 ] = 0;
      else if ( weight >= 3 ) weight_discrimination[ 0 ] = 4 - weight;
      else                    weight_discrimination[ 0 ] = 1;
      
      // ����
      if      ( weight >= 6 ) weight_discrimination[ 1 ] = 0;
      else if ( weight >= 5 ) weight_discrimination[ 1 ] = 6 - weight;
      else if ( weight >= 4 ) weight_discrimination[ 1 ] = 1;
      else if ( weight >= 3 ) weight_discrimination[ 1 ] = weight - 3;
      else                    weight_discrimination[ 1 ] = 0;
      
      // ��
      if      ( weight >= 6 ) weight_discrimination[ 2 ] = 1;
      else if ( weight >= 5 ) weight_discrimination[ 2 ] = weight - 5;
      else                    weight_discrimination[ 2 ] = 0;
      
      // ����
      int weight_index = -1;
      float most_weight_discrimination = 0.f;
      for ( int i = 0; i < 3; i++ )
      {
         if ( weight_discrimination[ i ] > most_weight_discrimination )
            weight_index = i;
      }
      
  
      System.out.print( "���(����: 1~10�ܰ�): " ); // ����� �Է¹���
      float play = sc.nextFloat();
      
      float play_discrimination[] = new float[ 3 ]; // ��� �з� �迭 ����
      
      // ����
      if      ( play >= 5 ) play_discrimination[ 0 ] = 0;
      else if ( play >= 3 ) play_discrimination[ 0 ] = -play / 2.f + 5 / 2.f;
      else                  play_discrimination[ 0 ] = 1;
      
      // ����
      if      ( play >= 7 ) play_discrimination[ 1 ] = 0;
      else if ( play >= 6 ) play_discrimination[ 1 ] = 7 - play;
      else if ( play >= 5 ) play_discrimination[ 1 ] = 1;
      else if ( play >= 4 ) play_discrimination[ 1 ] = play - 4;
      else                  play_discrimination[ 1 ] = 0;
      
      // ���
      if      ( play >= 8 ) play_discrimination[ 2 ] = 1;
      else if ( play >= 6 ) play_discrimination[ 2 ] = play / 2.f - 3;
      else                  play_discrimination[ 2 ] = 0;
      
      // ����
      int play_index = -1;
      float most_play_discrimination = 0.f;
      for ( int i = 0; i < 3; i++ )
      {
         if ( play_discrimination[ i ] > most_play_discrimination )
            play_index = i;
      }
      
      sc.close();

      // ���� ���� ��ᷮ
      float feed = 0.f;
      
      // ��� ����
      if ( play_index == 0 )
      {
         if      ( weight_index == 0 ) feed = weight * 70; // ����
         else if ( weight_index == 1 ) feed = weight * 70; // ����
         else if ( weight_index == 2 ) feed = weight * 70; // ��
      }
      // ��� ����
      else if ( play_index == 1 )
      {
         if      ( weight_index == 0 ) feed = weight * 80; // ����
         else if ( weight_index == 1 ) feed = weight * 80; // ����
         else if ( weight_index == 2 ) feed = weight * 80; // ��
      }
      // ��� ���
      else if ( play_index == 2 )
      {
         if      ( weight_index == 0 ) feed = weight * 90; // ����
         else if ( weight_index == 1 ) feed = weight * 90; // ����
         else if ( weight_index == 2 ) feed = weight * 90; // ��
      }
      System.out.println();
      System.out.printf( "���� ��ᷮ�� " + feed +"kcal �Դϴ�!"); // ���� ������ ���
   }
}