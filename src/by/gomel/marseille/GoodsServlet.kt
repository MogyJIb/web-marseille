package by.gomel.marseille

import by.gomel.marseille.domain.Injector
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class GoodsServlet : HttpServlet() {

    private val gson = Injector.provideGson()
    private val getGoodsUseCase = Injector.provideGetGoodsUseCase()

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val res = gson.toJson(getGoodsUseCase())
        response.apply {
            contentType = "application/json; charset=UTF-8"
            writer?.run {
                print(res)
                flush()
            }
        }
    }

}