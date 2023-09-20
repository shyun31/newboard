<template>
  <div>
    <div>
      <h2>조회</h2>
    </div>
    <form action="">
      <div>
        <input value=""/>
        <button id="search" @click="searchBt">조회</button>
      </div>

      <hr>

      <div class="listWrap">
          <table class="tbList">
            <tr>
              <td>번호</td>
              <td>구분</td>
              <td>제목</td>
              <td>첨부파일</td>
              <td>등록자</td>
              <td>등록일시</td>
              <td>수정자</td>
              <td>수정일시</td>
            </tr>
            <tr v-for="(row,i) in list" :key="i">
              <td>{{row.no}}</td>
              <td>{{row.subNo}}</td>
              <td>{{row.title}}</td>
              <td>{{row.fileName}}</td>
              <td>{{row.regUser}}</td>
              <td>{{row.regDate}}</td>
              <td>{{row.modUser}}</td>
              <td>{{row.modDate}}</td>
            </tr>
          </table>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: ''
    }
  }

  , methods: {
    searchBt() { //데이터 가져오기 함수
      this.body = { // 데이터 전송
        board_code: this.board_code
        , keyword: this.keyword
        , page: this.page
      }
      this.$axios.get('http://localhost:8888/search', {params: this.body})
          .then((res) => {
            this.list = res.data
            console.log(this.list)
          })

          .catch((err) => {
            console.log(err);
          })
    }
  }
}
</script>

<style scoped>

</style>