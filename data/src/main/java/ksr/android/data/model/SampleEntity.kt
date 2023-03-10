package ksr.android.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity : 변경이 되서는 안되는 Data Class. 가장 기본이 되는 Data Class 로 Api 에서 내려오는 데이터 형식이 바뀌어도 Entity 는 영향이 없도록 해야한다.
 *          즉, SampleEntity 로 명명을 해두었지만, 변경 가능성이 높은 API 같은 경우에는 Entity 가 아니라 DTO 라고 생각해야 한다.
 *          DB 입장에서는 해당 값들이 변경되면 안되는 값들이기 때문에 Entity 로 어노테이션을 선언하여 사용한다.
 */

@Entity(tableName = "sample")
data class SampleEntity(
    @PrimaryKey var title: String,
    @ColumnInfo var content: String
)