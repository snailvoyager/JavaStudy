package modern.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chapter3 {
    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();   //한 행을 읽는 코드
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {      //함수형 인터페이스 생성
        String process(BufferedReader b) throws IOException;
    }

    public String processFileNew(BufferedReaderProcessor p) throws IOException {  //인터페이스를 메서드 인수로 전달
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);   //BufferedReader 객체 처리
        }
    }

    public void main() throws Exception {
        String oneLine = processFileNew((BufferedReader br) -> br.readLine());  //람다 표현식으로 추상 메서드 구현을 직접 전달
        String twoLine = processFileNew((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
