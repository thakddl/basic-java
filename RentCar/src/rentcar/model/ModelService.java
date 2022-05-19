package rentcar.model;

import java.util.List;

public class ModelService {
    private static ModelService instance = new ModelService();
    public static ModelService getInstance() {
        return instance;
    }
    private ModelService() {}

    private ModelDAO dao = ModelDAO.getInstance();
	public List<ModelVO> getModelList() throws Exception {
		List<ModelVO> list = dao.getList();
		return list;
	}
	public ModelVO getModel(String mdId) throws Exception {
		ModelVO vo = dao.getModel(mdId);
		return vo;
	}
	public int insertModel(ModelVO vo) throws Exception {
		int result = dao.insertModel(vo);
		return result;
	}
	public int updateModel(ModelVO vo) throws Exception {
		int result = dao.updateModel(vo);
		return result;
	}
	public int deleteModel(String modelId) throws Exception {
		int result = dao.deleteModel(modelId);
		return result;
	  }
}
