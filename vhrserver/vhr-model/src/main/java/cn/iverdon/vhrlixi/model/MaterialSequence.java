package cn.iverdon.vhrlixi.model;

/**
 * @author iverdon
 * @date 2021/12/24 14:34
 */
public class MaterialSequence {

    private int id;

    private int materialId;

    private int preId;

    private int nextId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

}
