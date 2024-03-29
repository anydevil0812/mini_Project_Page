// import logo from "./logo.svg";
import "./App.css";
import HomePage from "./pages/HomePage";
import ContentPage from "./pages/ContentPage";
import ErrorPage from "./pages/ErrorPage";
import { Route, Router, Routes } from "react-router-dom";
import { useEffect, useState } from "react";
import { getDiarys } from "./api/getDiarys";
import axios from "axios";
import EditPage from "./pages/EditPage";
import InsertPage from "./pages/InsertPage";

function App() {
  const [data, setData] = useState([]); // 불러온 data
  const [currentPage, setCurrentPage] = useState(0); // 현재 페이지
  const [postsPerPage, setPostsPerPage] = useState(5); // 한 페이지당 게시글 수

  // 다이어리 불러오기 : getDiarys(currentPage, postPerPage, setData)
  useEffect(() => {
    getDiarys({ currentPage, postsPerPage, setData }); // api 사용
  }, [currentPage]);

  // console.log(data);
  // console.log(data.dtoList);

  const [currentPost, setCurrentPost] = useState([]);
  // console.log("currentPost" + currentPost);

  return (
    <div className="App">
      <Routes>
        {/* 메인페이지 : HomePage */}
        <Route
          path="/"
          element={
            <HomePage
              data={data}
              currentPage={currentPage}
              postsPerPage={postsPerPage}
              setCurrentPage={setCurrentPage}
              setPostsPerPage={setPostsPerPage}
            />
          }
        />
        {/* 게시글내용 : ContentPage */}
        <Route
          path="/content/:currentPage/:postNo"
          element={<ContentPage setCurrentPost={setCurrentPost} />}
        ></Route>
        {/* 게시글 수정 : EditPage */}
        <Route
          path="content/:currentPage/:postNo/edit-post"
          element={<EditPage currentPost={currentPost} />}
        />
        {/* 게시글 등록: InsertPage */}
        <Route path="/insert" element={<InsertPage />} />
        {/* 에러 : ErrorPage */}
        <Route path="*" element={<ErrorPage />} />
      </Routes>
    </div>
  );
}

export default App;
