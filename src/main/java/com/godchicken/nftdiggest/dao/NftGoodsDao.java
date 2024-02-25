package com.godchicken.nftdiggest.dao;

import com.godchicken.nftdiggest.entity.NftGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (NftGoods)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-17 21:45:53
 */
@Mapper
public interface NftGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NftGoods queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NftGoods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param nftGoods 实例对象
     * @return 对象列表
     */
    List<NftGoods> queryAll(NftGoods nftGoods);

    /**
     * 新增数据
     *
     * @param nftGoods 实例对象
     * @return 影响行数
     */
    int insert(NftGoods nftGoods);

    /**
     * 修改数据
     *
     * @param nftGoods 实例对象
     * @return 影响行数
     */
    int update(NftGoods nftGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}