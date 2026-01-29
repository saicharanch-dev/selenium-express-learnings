package proxy;

import dto.IEmployee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employee) {
        this.employeeTarget = employee;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // pre processing

        // making actual call to my service layer
        method.invoke(method,args);
        // post processing
        return null;
    }
}
