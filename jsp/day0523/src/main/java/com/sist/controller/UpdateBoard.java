package com.sist.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.rewrite.RewriteCond;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/UpdateBoard")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoard() {
        super();
        // TODO Auto-generated constructor stub
        dao = new BoardDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//수정할 게시물번호를 받아 온다.
		int no = Integer.parseInt(request.getParameter("no"));
		
		//그 게시물 번호 해당하는 게시물정보를 dao를 받아 온다.
		BoardVO b = dao.findByNo(no);
		
		//이것을 상태유지 합니다.
		request.setAttribute("b", b);
		
		//수정할 뷰페이지로 이동합니다.
		String viewPage = "updateBoard.jsp";
		RequestDispatcher dispatcher  = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no  = Integer.parseInt(request.getParameter("no"));
		String pwd  = request.getParameter("pwd");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO b = new BoardVO();
		b.setNo(no);
		b.setPwd(pwd);
		b.setTitle(title);
		b.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int re = dao.updateBoard(b);
		
		if(re == 1) {
			response.sendRedirect("ListBoard");
		}else {
			request.setAttribute("msg", "게시물 수정에 실패하였습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}