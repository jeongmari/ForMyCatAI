import java.util.Scanner;

public class CatFeed
{
   public static void main( String[] args )
   {
      Scanner sc = new Scanner( System.in );
      
    
      System.out.print( "체중(단위: kg): " ); // 체중을 입력받음
      float weight = sc.nextFloat();
      
      float weight_discrimination[] = new float[ 3 ]; // 체중 분류 배열 생성
      
      // 마름
      if      ( weight >= 4 ) weight_discrimination[ 0 ] = 0;
      else if ( weight >= 3 ) weight_discrimination[ 0 ] = 4 - weight;
      else                    weight_discrimination[ 0 ] = 1;
      
      // 보통
      if      ( weight >= 6 ) weight_discrimination[ 1 ] = 0;
      else if ( weight >= 5 ) weight_discrimination[ 1 ] = 6 - weight;
      else if ( weight >= 4 ) weight_discrimination[ 1 ] = 1;
      else if ( weight >= 3 ) weight_discrimination[ 1 ] = weight - 3;
      else                    weight_discrimination[ 1 ] = 0;
      
      // 비만
      if      ( weight >= 6 ) weight_discrimination[ 2 ] = 1;
      else if ( weight >= 5 ) weight_discrimination[ 2 ] = weight - 5;
      else                    weight_discrimination[ 2 ] = 0;
      
      // 결정
      int weight_index = -1;
      float most_weight_discrimination = 0.f;
      for ( int i = 0; i < 3; i++ )
      {
         if ( weight_discrimination[ i ] > most_weight_discrimination )
            weight_index = i;
      }
      
  
      System.out.print( "운동량(단위: 1~10단계): " ); // 운동량을 입력받음
      float play = sc.nextFloat();
      
      float play_discrimination[] = new float[ 3 ]; // 운동량 분류 배열 생성
      
      // 부족
      if      ( play >= 5 ) play_discrimination[ 0 ] = 0;
      else if ( play >= 3 ) play_discrimination[ 0 ] = -play / 2.f + 5 / 2.f;
      else                  play_discrimination[ 0 ] = 1;
      
      // 보통
      if      ( play >= 7 ) play_discrimination[ 1 ] = 0;
      else if ( play >= 6 ) play_discrimination[ 1 ] = 7 - play;
      else if ( play >= 5 ) play_discrimination[ 1 ] = 1;
      else if ( play >= 4 ) play_discrimination[ 1 ] = play - 4;
      else                  play_discrimination[ 1 ] = 0;
      
      // 충분
      if      ( play >= 8 ) play_discrimination[ 2 ] = 1;
      else if ( play >= 6 ) play_discrimination[ 2 ] = play / 2.f - 3;
      else                  play_discrimination[ 2 ] = 0;
      
      // 결정
      int play_index = -1;
      float most_play_discrimination = 0.f;
      for ( int i = 0; i < 3; i++ )
      {
         if ( play_discrimination[ i ] > most_play_discrimination )
            play_index = i;
      }
      
      sc.close();

      // 일일 적정 사료량
      float feed = 0.f;
      
      // 운동량 부족
      if ( play_index == 0 )
      {
         if      ( weight_index == 0 ) feed = weight * 70; // 마름
         else if ( weight_index == 1 ) feed = weight * 70; // 보통
         else if ( weight_index == 2 ) feed = weight * 70; // 비만
      }
      // 운동량 보통
      else if ( play_index == 1 )
      {
         if      ( weight_index == 0 ) feed = weight * 80; // 마름
         else if ( weight_index == 1 ) feed = weight * 80; // 보통
         else if ( weight_index == 2 ) feed = weight * 80; // 비만
      }
      // 운동량 충분
      else if ( play_index == 2 )
      {
         if      ( weight_index == 0 ) feed = weight * 90; // 마름
         else if ( weight_index == 1 ) feed = weight * 90; // 보통
         else if ( weight_index == 2 ) feed = weight * 90; // 비만
      }
      System.out.println();
      System.out.printf( "적정 사료량은 " + feed +"kcal 입니다!"); // 일일 적정량 출력
   }
}