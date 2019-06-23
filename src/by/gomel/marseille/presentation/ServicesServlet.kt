package by.gomel.marseille.presentation

import by.gomel.marseille.domain.Injector
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ServicesServlet : HttpServlet() {

    private val gson = Injector.provideGson()
    private val getServicesUseCase = Injector.provideGetServicesUseCase()

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val res = gson.toJson(getServicesUseCase())
        response.apply {
            contentType = "application/json; charset=UTF-8"
            writer?.run {
                print(res)
                flush()
            }
        }
    }

}