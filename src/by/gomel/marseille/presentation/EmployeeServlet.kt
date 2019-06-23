package by.gomel.marseille.presentation

import by.gomel.marseille.domain.Injector
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class EmployeeServlet : HttpServlet() {

    private val gson = Injector.provideGson()
    private val getEmployeesUseCase = Injector.provideGetEmployeesUseCase()

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val res = gson.toJson(getEmployeesUseCase())
        response.apply {
            contentType = "application/json; charset=UTF-8"
            writer?.run {
                print(res)
                flush()
            }
        }
    }

}