package rentcar.model;

import java.util.List;


public class ModelController {
    private static ModelController instance = new ModelController();
    public static ModelController getInstance() {
        return instance;
    }
    private ModelController() {}

    private ModelService service = ModelService.getInstance();
	public List<ModelVO> getModelList() throws Exception {
		return service.getModelList();
	}
	public ModelVO getModel(String mdId) throws Exception {
		return service.getModel(mdId);
	}
	public int insertModel(ModelVO vo) throws Exception {
		return service.insertModel(vo);
	}
	public int updateModel(ModelVO vo) throws Exception {
       return service.updateModel(vo);
    }
	public int deleteModel(String modelId) throws Exception {
		return service.deleteModel(modelId);
	}
}
