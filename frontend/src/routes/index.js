import Vue from 'vue';
import Router from 'vue-router';
import SearchBoard from "@/components/SearchBoard";

Vue.use(Router); //vue 라우터 사용

// 라우터 설치 npm install vue-router@3
// 설치시 버전 확인
export default new Router({
    routes:[
        {
            path:'/api/searchboard'
            ,name:SearchBoard
            ,component:SearchBoard
        }
    ]
})