package com.godchicken.nftdiggest.service.impl;

import com.godchicken.nftdiggest.entity.NftGoods;
import com.godchicken.nftdiggest.dao.NftGoodsDao;
import com.godchicken.nftdiggest.service.NftGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (NftGoods)表服务实现类
 *
 * @author makejava
 * @since 2022-04-17 21:45:53
 */
@Service("nftGoodsService")
public class NftGoodsServiceImpl implements NftGoodsService {
    @Resource
    private NftGoodsDao nftGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public NftGoods queryById(Integer id) {
        return this.nftGoodsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<NftGoods> queryAllByLimit(int offset, int limit) {
        return this.nftGoodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nftGoods 实例对象
     * @return 实例对象
     */
    @Override
    public NftGoods insert(NftGoods nftGoods) {
        this.nftGoodsDao.insert(nftGoods);
        return nftGoods;
    }

    /**
     * 修改数据
     *
     * @param nftGoods 实例对象
     * @return 实例对象
     */
    @Override
    public NftGoods update(NftGoods nftGoods) {
        this.nftGoodsDao.update(nftGoods);
        return this.queryById(nftGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nftGoodsDao.deleteById(id) > 0;
    }
}