import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SystemArrayCopyTest {

    @Test
    @DisplayName("System.arraycopy() 메소드 사용하기")
    void systemArrayCopyTest() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        System.arraycopy(src, 0, dest, 0, 5);
        // then
        assertThat(src).isEqualTo(dest);
    }

    @Test
    @DisplayName("원본 배열의 복사할 요소 개수 조절하기")
    void changeCopyLength() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        System.arraycopy(src, 0, dest, 0, 3);
        //then
        int[] result = {1, 2, 3, 0, 0};
        assertThat(dest).isEqualTo(result);
    }

    @Test
    @DisplayName("원본 배열의 시작 위치 변경하기")
    void changeCopyStartPoint() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        System.arraycopy(src, 2, dest, 0, 3);
        // then
        int[] result = {3, 4, 5, 0, 0};
        assertThat(dest).isEqualTo(result);
    }

    @Test
    @DisplayName("대상 배열의 시작 위치 변경하기")
    void changeCopyEndPoint() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        System.arraycopy(src, 2, dest, 2, 3);
        // then
        int[] result = {0, 0, 3, 4, 5};
        assertThat(dest).isEqualTo(result);
    }

    @Test
    @DisplayName("원본 배열의 시작 위치 + 복사할 요소 개수의 크기가 원본 배열의 크기보다 큰 경우 에러")
    void outOfSrcArrayLength() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        assertThatThrownBy(() -> System.arraycopy(src, 3, dest, 0, 3))
                .isInstanceOf(IndexOutOfBoundsException.class); // then
    }

    @Test
    @DisplayName("대상 배열의 시작 위치 + 복사할 요소 개수의 크기가 대상 배열의 크기보다 큰 경우 에러")
    void outOfDestArrayLength() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // when
        assertThatThrownBy(() -> System.arraycopy(src, 0, dest, 3, 3))
                .isInstanceOf(IndexOutOfBoundsException.class); // then
    }

    @Test
    @DisplayName("Arrays.copyOf() 메소드와 비교하기")
    void arraysCopyOf() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[3]; // 크기가 3이라는 것에 주목
        // when
        System.arraycopy(src, 0, dest, 0, 3);
        int[] result = Arrays.copyOf(src, 3);
        // then
        assertThat(dest).isEqualTo(result);
    }

    @Test
    @DisplayName("Arrays.copyOf() 메소드에서 배열의 크기를 넘어가는 경우")
    void outOfBoundsArrayLength() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[8]; // 크기가 8이라는 것에 주목
        // when
        System.arraycopy(src, 0, dest, 0, 5);
        int[] result = Arrays.copyOf(src, 8);
        // then
        assertThat(dest).isEqualTo(result);
    }

    @Test
    @DisplayName("정해진 범위 복사하기")
    void copyOfRange() {
        // given
        int[] src = {1, 2, 3, 4, 5};
        // when
        int[] dest = Arrays.copyOfRange(src, 2, 8); // 8번째는 제외
        int[] result = {3, 4, 5, 0, 0, 0};
        // then
        assertThat(dest).isEqualTo(result);
    }
}
