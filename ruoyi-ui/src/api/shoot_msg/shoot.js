import request from '@/utils/request'

// 查询拍摄信息列表
export function listShoot(query) {
  return request({
    url: '/shoot_msg/shoot/list',
    method: 'get',
    params: query
  })
}

// 查询拍摄信息详细
export function getShoot(photoId) {
  return request({
    url: '/shoot_msg/shoot/' + photoId,
    method: 'get'
  })
}

// 新增拍摄信息
export function addShoot(data) {
  return request({
    url: '/shoot_msg/shoot',
    method: 'post',
    data: data
  })
}

// 修改拍摄信息
export function updateShoot(data) {
  return request({
    url: '/shoot_msg/shoot',
    method: 'put',
    data: data
  })
}

// 删除拍摄信息
export function delShoot(photoId) {
  return request({
    url: '/shoot_msg/shoot/' + photoId,
    method: 'delete'
  })
}
