package kr.hs.dgsw.java.community.mapper;

import kr.hs.dgsw.java.community.domain.Post;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface CommunityMapper {
    // TODO 테이블 명 및 컬럼명 바꾸기

    @Select("SELECT * FROM writing;")
    List<Post> getPostList();

    @Select("SELECT * FROM writing WHERE idx = #{idx};")
    Post getPost(@Param("idx") Integer idx);

    @Insert("INSERT INTO writing VALUES (null, #{content}, #{title}, #{writer}, #{write_time});")
    void insert(
            @Param("title") String title,
            @Param("content") String content,
            @Param("writer") String writer,
            @Param("write_time") Date writeTime
    );

    @Update("UPDATE writing SET ")
    void update(
            @Param("content") String content,
            @Param("title") String title,
            @Param("writer") String writer
    );

    @Delete("")
    void delete();
}
