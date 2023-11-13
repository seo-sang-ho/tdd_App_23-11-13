package com.ll.global.app;

import com.ll.standard.util.TestUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTest {

    @Test
    @DisplayName("프로그램 시작 시 == 명언 == 출력")
    void t1(){
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        Assertions.assertThat(out).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("종료")
    void t2(){
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

    }

    @Test
    @DisplayName("등록")
    void t3(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라
                작가미상
                종료
                """.stripIndent());

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        Assertions.assertThat(out)
                .contains("명언 :")
                .contains("작가 :");

    }
}
