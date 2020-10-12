import Vue from 'vue'

export const userKey = '__knowledge_user'
export const baseApiUrl = 'http://ec2-35-173-243-207.compute-1.amazonaws.com:4001'
// export const baseApiUrl = 'http://localhost:4001'

export function showError(e) {
    if(e && e.response && e.response.data) {
        Vue.toasted.global.defaultError({ msg : e.response.data })
    } else if(typeof e === 'string') {
        Vue.toasted.global.defaultError({ msg : e })
    } else {
        Vue.toasted.global.defaultError()
    } 
}

export default { baseApiUrl, showError, userKey }