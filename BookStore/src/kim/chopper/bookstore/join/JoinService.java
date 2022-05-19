package kim.chopper.bookstore.join;

import kim.chopper.bookstore.common.HomeMenu;

public class JoinService {
    private static JoinService instance = new JoinService();
    public static JoinService getInstance() {
        return instance;
    }
    private JoinService() {}

    private JoinDAO dao = JoinDAO.getInstance();

    public CustomerVO findCustomer(int custId) {
        return dao.findCustomer(custId);
    }

    public int join(CustomerVO vo) {
        return dao.join(vo);
    }

    public int modifyInfo(CustomerVO vo, HomeMenu menu) {
        int result = 0;
        switch (menu) {
            case MODIFY_NAME:
                result = dao.modifyName(vo);
                break;
            case MODIFY_ADDRESS:
                result = dao.modifyAddress(vo);
                break;
            case MODIFY_PHONE:
                result = dao.modifyPhone(vo);
                break;
        }
        return result;
    }

    public int modifyPassword(CustomerVO vo) {
        return dao.modifyPassword(vo);
    }
}
