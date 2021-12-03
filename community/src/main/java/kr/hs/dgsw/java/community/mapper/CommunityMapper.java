package kr.hs.dgsw.java.community.mapper;

import kr.hs.dgsw.java.community.domain.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface CommunityMapper {
    // TODO 테이블 명 및 컬럼명 바꾸기

    @Select("SELECT * FROM writing;")
    List<Post> getPostList();

    @Insert("INSERT INTO writing VALUES ()")
    void insert();

    @Update("UPDATE writing SET ")
    void update(
            @Param("content") String content,
            @Param("title") String title,
            @Param("writer") String writer
    );

    @Delete("")
    void delete();
}
