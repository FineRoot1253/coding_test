package basic_mathematics_1;

import java.util.ArrayList;
import java.util.List;

public class MAverage {

    /**
     *
     * @param inputRecord random Integer Value List
     *                    [1,12,20,11,7, ...]
     * @param M 인접 평균을 구할 범위
     *          예를 들면 3일 경우 [1,12,20의 평균, 12,20,11의 평균, ...] 이런식으로 구하게 된다.
     * @return List<int> 이동 평균 리스트
     */
    static List<Integer> bruteForceSolution(List<Integer> inputRecord, int M){
        List<Integer> resultRecord =  new ArrayList<>();

        for (int i = 0; i < inputRecord.size(); i++) {

            Integer mSum = 0;
            for (int j = 0; j < M; j++) {
                mSum += inputRecord.get(j);
            }
            resultRecord.add(mSum/M);
        }

        return resultRecord;
    }

    /**
     *
     * @param inputRecord random Integer Value List
     *                    [1,12,20,11,7, ...]
     * @param M 인접 평균을 구할 범위
     *          예를 들면 3일 경우 [1,12,20의 평균, 12,20,11의 평균, ...] 이런식으로 구하게 된다.
     * @return List<Integer> 이동 평균 리스트
     */
    static List<Integer> solution(List<Integer> inputRecord, int M){
        List<Integer> resultRecord =  new ArrayList<>();
        Integer mSum = 0;

        // step 설명
        // 1) 0 ~ M만큼 더한 mSum을 만듭니다. (초반 루프 0~M 총합 토막)
        // 2) 이것을 하나씩 겹치는 만큼 더하고 겹치지 않는 부분은 빼는 방식으로 더합니다.
        // 이러면 이론상 브루트포스와 거치는 실행흐름은 다르지만 실핼절차는 똑같습니다
        // ex) 0~M, 1~M+1(-=0번째, +=M+1번째), 2~M+2(-=1번째, +=M+2번째) ... 이런식으로 진행된다.


        for (int i = 0; i < M; i++) {
            mSum += inputRecord.get(i);
        }
        for (int j = M; j < inputRecord.size(); j++) {
            mSum += inputRecord.get(j+1);
            resultRecord.add(mSum/M);
            mSum-=inputRecord.get(j-M);
        }

        return resultRecord;
    }


    static class DummyData{
        List<Integer> list = new ArrayList<>();

        DummyData(int totalLength,int spectrumLimit){
            for (int i = 0; i < totalLength; i++) {
                list.add(new Integer((int) (Math.random() * (spectrumLimit -1) + 1)));
            }
        }

        public List<Integer> getList() {
            return list;
        }

        @Override
        public String toString() {
            return "DummyData{" +
                    "list=" + list +
                    '}';
        }
    }


    public static void main(String[] arg){
        // given
        DummyData tcData = new DummyData(100,10);

        // when
        List<Integer> bruteForceSolutionResult = bruteForceSolution(tcData.getList(),5);
        List<Integer> solutionResult = solution(tcData.getList(),5);

        // than
        System.out.println("bruteForceSolutionResult = " + bruteForceSolutionResult);
        System.out.println("solutionResult = " + solutionResult);


    }

}
