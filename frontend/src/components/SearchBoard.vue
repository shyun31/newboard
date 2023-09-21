<template>
  <div>
    <div>
      <h2>조회</h2>
    </div>
    <div class="searchNav">
      번호 : <input id="searchNum" type="number" v-model="searchNum"/>&nbsp;&nbsp;
      Title : <input id="searchTitle" type="text" v-model="searchTitle"/>&nbsp;&nbsp;
      <button id="search" type="submit" @click="searchBt">조회</button>
    </div>
    <div class="savePopup">
      <button @click="savePopup()">등록</button>
      <button @click="deleteBt()">삭제</button>
    </div>
    <br><br>
    <div class="listWrap">
      <form>
        <table class="tbList">
          <tr>
            <th scope="row">
              <input type="checkbox"
                     v-model="allChecked"
                     @click="checkedAll($event.target.checked)">
            </th>
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
            <th scope="row">
              <input type="checkbox" v-model="checkList" :value="row.no">
            </th>
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
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: '',
      boardList: [],
      allChecked: false,
      check: false,
      searchNum: '',
      searchTitle: null,
      checkList: []
    }
  },
  methods: {
    searchBt() {
      this.body = {
        no : this.searchNum,
        title : this. searchTitle
      }
      this.$axios.get('http://localhost:8081/search', {params: this.body})
          .then((res) => {
            this.list = res.data
            console.log(this.list)
          })

          .catch((err) => {
            console.log(err);
          })
    },
    deleteBt() {
      console.log(this.checkList)
      this.checkList.forEach((data) => {
        this.$axios.delete('http://localhost:8081/delete/' + data, {})
            .then(() => {
            })
      })
    },
  }
}
</script>

<style scoped>
  .savePopup {
    float: right;
  }
</style>