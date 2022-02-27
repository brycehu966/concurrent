package com.bryce.special.column.concurrentModel.stm;

/**
 * @author bryce
 * @version 1.0.0
 * @Description TxnRef 这个类负责完成事务内的读写操作
 */
public class TxnRef<T> {
    //支持事务的引用
    //当前数据，带版本号
    volatile VersionedRef curRef;

    //构造方法
    public TxnRef(T value) {
        this.curRef = new VersionedRef(value, 0L);
    }

    //获取当前事务中的数据
    public T getValue(Txn txn) {
        return txn.get(this);
    }

    //在当前事务中设置数据
    public void setValue(T value, Txn txn) {
        txn.set(this, value);
    }

}
