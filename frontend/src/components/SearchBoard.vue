<template>
  <div>
    <InsertBoard v-if="this.openModal == true"/>

    <div>
      <h2>조회</h2>
    </div>
    <div class="searchNav">
      번호 : <input id="searchNum" type="number" v-model="searchNum"/>&nbsp;&nbsp;
      제목 : <input id="searchTitle" type="text" v-model="searchTitle"/>&nbsp;&nbsp;
      <button id="search" type="submit" @click="searchBt">조회</button>
    </div>
    <div class="pop">
      <button @click="savePopup()">등록</button>
      <button @click="deleteBt()">삭제</button>
    </div>
    <br><br>
    <div class="listWrap">
      <form>
        <table class="tbList" border="1">
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
              <input type="checkbox" v-model="checkList" :value="row.non">
            </th>
            <td>{{row.non}}</td>
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
import InsertBoard from './InsertBoard';

export default {
  data() {
    return {
      list: '',
      boardList: [],
      allChecked: false,
      check: false,
      openModal: false,
      searchNum: '',
      searchTitle: null,
      checkList: []
    }
  },
  components: {
    InsertBoard,
  },
  methods: {
    searchBt() {
      this.body = {
        non : this.searchNum,
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
               this.searchBt()
            })
      })
    },
    savePopup() {
      this.openModal = !this.openModal
    },
    handleOk(bvModalEvt) {
      // Prevent modal from closing
      bvModalEvt.preventDefault()
      // Trigger submit handler
      this.handleSubmit()
    },
    checkFormValidity() {
      const valid = this.$refs.form.checkValidity()
      this.nameState = valid
      return valid
    },
    handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity()) {
        return
      }
      // Push the name to submitted names
      this.submittedNames.push(this.name)
      // Hide the modal manually
      /* this.$nextTick(() => {
        // this.$bvModal.hide('addQna')
      }) */
    },
  }
}
</script>

<style scoped>
  .pop {
    float: right;
  }
</style>