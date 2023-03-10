package ksr.android.data.model

/**
 * DTO : 변경이 쉽게 가능한 Data Class.
 *        데이터 형태나 구조가 바뀔 수 있는 경우 사용하는 Data Class. DTO 를 가공하여 Entity 에 넣어 사용하기 때문에, 실제로 사용하는
 *        데이터가 변경되지 않는 이상 다른 구조에 영향이 없다.
 */
data class SampleDTO(
    val title: String,
    val content: String
)
