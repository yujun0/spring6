package cn.powernode.service;

import cn.powernode.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    @Resource(name = "xyz")
//    private StudentDao studentDao;
//    @Resource
//    private StudentDao studentDao;

    // =================================================================================
//    @Resource
//    private StudentDao studentDao;
//
//    public void deleteStudent() {
//        studentDao.deleteById();
//    }
    // =================================================================================
//    private StudentDao studentDao;
//
//    @Resource
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }
//
//    public void deleteStudent() {
//        studentDao.deleteById();
//    }
    // =================================================================================
    private StudentDao studentDao;

    @Resource(name = "studentDaoImplForOracle")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStudent() {
        studentDao.deleteById();
    }
    // =================================================================================
//    private StudentDao studentDao;
//    // 不能出現在構造方法上。
//    @Resource(name = "studentDaoImplForMySQL")
//    public StudentService(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    /*@Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/
}


